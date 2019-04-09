var person = {};

person.name = '소녀시대';
person['age'] = 20;
person.add = function(a,b){
    return a+b;
};

var oper = function(a,b){
    return a*b;
};




console.log(person.add(20,30));
console.log(oper(10,20));