var express = require('express');
var http = require('http');

var app = express();

app.set('port', process.env.PORT||3000);

app.use(function(req, res, next){
    console.log('첫 번째 미들웨어 호출됨');
    
    var userAgent = req.header('User-Agent');
    var paramName = req.query.name;
    
    res.send('<h3>서버에서 응답 User-Agent -> ' + userAgent  +'</h3>'
    + '<h3>Param Name -> '+ paramName + '</h3>');
    
});

var server = http.createServer(app).listen(app.get('port'),function(){
    console.log('익스프레스로 웹서버 실행 : ' + app.get('port'));
    
});