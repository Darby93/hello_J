var express = require('express');
var http = require('http');
var static = require('serve-static');
var path = require('path');

var bodyParser = require('body-parser');


var app = express();

app.set('port', process.env.PORT||3000);
// app.use(static(path.join(__dirname, 'public')));
app.use('/public', static(path.join(__dirname, 'public')));

app.use(bodyParser.urlencoded({extended:false}));
app.use(bodyParser.json());

app.use(function(req, res, next) {
    console.log('첫 번째 미들웨어 실행');

    var userAgent = req.header('User-Agent');
    var paramId = req.body.id || req.query.id;

    res.send('<h3>서버에서 응답 User-Agent -> ' + userAgent  +'</h3>'
    + '<h3>Param Id -> '+ paramId + '</h3>');
    
});

var server = http.createServer(app).listen(app.get('port'),function(){
    console.log('익스프레스로 웹서버 실행 : ' + app.get('port'));
    
});