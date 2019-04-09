var http = require('http');

var server = http.createServer();

var host = '192.168.0.8';
var port = 3000;

server.listen(port, host, '20',function(){
    console.log('웹서버가 실행되었습니다 -> '+ host + ' : ' + port);
});


