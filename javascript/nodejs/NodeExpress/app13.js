/*
- 미들웨어 : 구조 내에서 중간 처리를 위한 함수(함수들의 꾸러미가 모듈)
1)  express 프레임워크에서 사용할 수 있는 중간 처리 목적의 소프트웨어 : 기본적인 express 구조 내에서 처리 목적으로 사용
2) 요청에 대한 응답을 완수하기 전까지 중간중간 다양한 일을 처리할 수 있음
3) 미들웨어 함수 생명주기 : request - response 응답을 주기로 종료 
4) 미들웨어 함수 우선순위 : 먼저 로드되는 미들웨어 함수가 먼저 실행됨(코드 순서 중요)


*/



//HTTP 웹서버를 생성하는 것과 관련된 기능을하는 모듈
var http = require('http');

//웹서버를 생성하는데 더많은 기능을 가지는 모듈
var express = require('express');

//
var static = require('serve-static');
var path = require('path');

//post요청 데이터를 추출
var bodyParser = require('body-parser');

//요청 쿠키데이터를 추출
var cookieParser = require('cookie-parser');
var expressSession = require('express-session');

// express에 multer모듈 적용 (for 파일업로드)
// 파일업로드를 도와주는 외장모듈
var multer = require('multer');

//파일을 다루는 모듈 등록
var fs = require('fs');

//하나의 서버만 접속할 수 있는데
//다른서버로 접속을 클라이언트에서 바로 할 수 있게 도와주는 모듈 (다중서버접속)
var cors = require('cors');

//express 함수호출    express의 기능을 app에 담는거죠
var app = express();

//속성설정인데   여기서는 포트번호 설정  
app.set('port', process.env.PORT||3000);

//__dirname 현재폴더에서 public 열어주겠다 파일경로생성
//__dirname  현재파일이 실행되는 폴더경로  + 그안에 퍼블릭 경로 붙여서 합쳐줌
app.use('/public', static(path.join(__dirname, 'public')));


//__dirname 현재폴더에서 uploads를 열어주겠다
//static 확인해보기
app.use('/uploads',static(path.join(__dirname, 'uploads')));


app.use(bodyParser.urlencoded({extended:false}));
app.use(bodyParser.json());

// 요청된 쿠키를 쉽게 추출할 수 있도록 해주는 미들웨어.
// request 객체에 cookies 속성이 부여된다.
app.use(cookieParser());

// express-session 미들웨어를 사용하기위해 app에 등록
app.use(expressSession({
    secret:"my key",
    resave:true, //저장할 정보를 나중에넣어줄꺼냐 지금넣어줄꺼냐 같은느낌?  
    saveUninitialized:true
}));

app.use(cors());

var storage = multer.diskStorage({   //저장경로와 파일명  설정
    destination: function(req, file, callback){
        callback(null, 'uploads'); // cb 콜백함수를 통해 전송된 파일 저장 디렉토리 설정
    },
    filename:function(req, file, callback){
        //callback(null, file.originalname + Date.now());

        //extname 확장자만빼줌 확장자만 저장
        var extension = path.extname(file.originalname);
        //확장자만 뺀 파일이름 저장
        var basename = path.basename(file.originalname, extension);
        callback(null, basename + Date.now() + extension); // cb 콜백함수를 통해 전송된 파일 이름 설정
    }
}); //객체를 넣어 설정정보를 넣어줌

var upload = multer({  
    storage:storage,
    limits:{
        files:10,  //최대파일수
        fileSize:1024*1024*1024 //최대 파일 사이즈 
    }
});

//라우팅 함수 등록
//URI가 클라이언트 요청에 응답하는 방식
var router = express.Router();

router.route('/process/photo').post(upload.array('photo',1), function(req, res){
    console.log('/process/photo 라우팅 함수 호출됨.');
    
    var files = req.files;
    console.log('==== 업로드된 파일 ====');

    if(files.length > 0){
        console.dir(files[0]);
    } else {
        console.log('파일이 없습니다');
    }
    
    var originalname;
    var filename;
    var mimetype;
    var size;

    if (Array.isArray(files)){
        for(var i=0; i<files.length; i++) {
            originalname = files[i].originalname;
            filename = files[i].filename;
            mimetype = files[i].mimetype;
            size = files[i].size;
        }
    }
    
    res.writeHead(200, {"Content-Type":"text/html;charset=utf8"});
    res.write("<h1>파일업로드</h1>");
    res.write("<p>원본파일 : " + originalname + "</p>");
    res.write("<p>저장파일 : " + filename + "</p>");
});

router.route('/process/showCookie').get(function(req,res){
    console.log('/process/showCookie 라우팅 함수 호출됨');

    res.send(req.cookies);
    
});


router.route('/process/setUserCookie').get(function(req, res){
    console.log('/process/setUserCookie 라우팅 함수 호출됨');
    
    res.cookie('user',{
        id : 'mike',
        name : '소녀시대',
        authorized : true   //인증 됫니 ?  확인하는거
    });

    res.redirect('/process/showCookie');
});



app.use('/', router);

app.all('*', function(req, res){
    res.status(404).send('<h1>요청하신 페이지는 없어요.</h1>');
});

http.createServer(app).listen(app.get('port'), function(){
    console.log('익스프레스로 웹서버 실행  : ' + app.get('port'));
    
});