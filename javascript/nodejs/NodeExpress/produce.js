var express =require('express');
var http = require('http');
var path = require('path');

var bodyParser = require('body-parser');
var cookieParser = require('cookie-parser');

//////////////////////////////////////////////////


var app = express();

app.set('port', process.evnPORT || 3000);

app.use(bodyParser.urlencoded({extended:false}));

app.use(bodyParser.json());

app.use('/public', static)