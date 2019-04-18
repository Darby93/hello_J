var express = require('express');
var http = require('http');
var path = require('path');
var static = require('serve-static');

var bodyParser = require('body-parser');
var cookieParser = require('cookie-parser');
var expressSession = require('express-session');

var expressErrorHandler = require('express-error-handler');

var app = express();

app.set('port', process.env.PORT || 3000);
app.use('/public', static(path.join(__dirname, 'public')));

app.use(bodyParser.urlencoded({extended:false}));
app.use(bodyParser.json());

app.use(cookieParser());
app.use(expressSession({
    secret : 'my key',
    resave : true,
    saveUninitialized : true
}));

var route = express.Router();

app.use('/', router );
// app.use('*' , function(req, res){
//     res.status(404).send('<h1>요청하신 페이지는 없어요</h1>');
// });

var errorHandler = expressErrorHandler({
    static: {
        '404' : './public/404.html'
    }
});

var server = http.createServer(app).listen(app.get('port'), function(){
    console.log('익스프레스로 웹 서버를 실행함 : ' + app.get('port'));
    
});