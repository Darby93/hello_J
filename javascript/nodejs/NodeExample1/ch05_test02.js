var http = require('http');

var server = http.createServer();

var host='192.168.0.8'
var port = 3000;
server.listen(port, host, 25, function(){
    console.log('웹서버 실행됨.');
});

server.on('connection', function(socket){
    console.log('클라이언트가 접속했습니다.');
});

server.on('request', function(req, res){
    //req 요청객체 , res 응답객체
    console.log('클라이언트 요청이 들어왔습니다');
    // console.dir(req);

    res.writeHead(200, {"Content-Type":"text/html;charset=utf-8"});
    res.write('<h1>웹서버로부터 받음 응답</h1>')
    
});


