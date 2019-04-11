var http = require('http');
var express = require('express');
var static = require('serve-static');
var path = require('path');

var bodyParser = require('body-parser');
var cookieParser = require('cookie-parser');
var expressSession = require('express-session');

var app = express();

app.set('port', process.env.PORT||3000);
app.use('/public', static(path.join(__dirname, 'public')));

app.use(bodyParser.urlencoded({extended:false}));
app.use(bodyParser.json());

app.use(cookieParser());
app.use(expressSession({
    secret:"my key",
    resave:true, //저장할 정보를 나중에넣어줄꺼냐 지금넣어줄꺼냐 같은느낌?  
    saveUninitialized:true
}));

var router = express.Router();

router.route('/process/showCookie').get(function(req,res){
    console.log('/process/showCookie 라우팅 함수 호출됨');

    res.send(req.cookies);
    
});

router.route('/process/product').get(function(req, res){
    console.log('/process/product 라우팅 함수 호출됨.');
    
    if (req.session.user) {
        res.redirect('/public/product.html');
    } else {
        res.redirect('/public/login2.html');
    }
    
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