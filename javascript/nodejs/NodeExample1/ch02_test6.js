var nconf = requir('nconf');
nconf.env();

var value = nconf.get('OS');
console.log('OS 환경 변수의 값 : %s', value);