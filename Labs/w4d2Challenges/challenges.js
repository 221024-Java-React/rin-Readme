
// challenge 1
function calcAge(age){
    var convert = 0;
    if(age){
        return age * 365;
    }else
        return 0;
}

console.log(calcAge(65));
console.log(calcAge(0));
console.log(calcAge(20));

//challenge 2
function points(two, three){
    var twopointers = 0;
    var threepointers = 0;

    two = two * 2;
    three = three * 3;

    twopointers += two;
    threepointers += three;

    return twopointers + threepointers;
}

console.log(points(1,1));
console.log(points(7,5));
console.log(points(38,8));

//challenge 3
function reverse(arr){
    var reversedArr = [];
    for(let i = arr.length-1; i >= 0 ; i--){
        reversedArr.push(arr[i]);
    }
    
    return reversedArr;
}

console.log(reverse([1,2,3,4]));
console.log(reverse([9,9,2,3,4]));
console.log(reverse([]));

//challenge 4
function getVoteCount(votes){
    var data = {
        upvotes: 0,
        downvotes: 0
    }

    data.upvotes = votes.upvotes;
    data.downvotes = votes.downvotes*-1;

    return (data.upvotes + data.downvotes);
}

console.log(getVoteCount({upvotes: 13, downvotes: 0}));
console.log(getVoteCount({upvotes: 2, downvotes: 33}));
console.log(getVoteCount({upvotes: 132, downvotes: 132}));

//challenge 5
function newWord(word){
    var newString = "";
    if(typeof word === 'string'){
        for(let i=0; i < word.length; i++){
            if(i != 0){
                newString += word[i];
            }
        }
    }

    return newString;
}

console.log(newWord("apple"));
console.log(newWord("cherry"));
console.log(newWord("plum"));

//challenge 6
function arrayToString(arr){
    let newString = "";
    for(let i=0; i<arr.length; i++){
        newString += arr[i];
    }

    return newString;
}

console.log(arrayToString([1,2,3,4,5,6]));
console.log(arrayToString(["a","b","c","d","e","f"]));
console.log(arrayToString([1,2,3,"a","s","dAAAA"]));

//challenge 7
function findIndex(arr, str){
    if(typeof str === 'string'){
        for(let i=0; i<arr.length; i++)
        {
            if(str == arr[i]){
                return i;
            }
        }
    }  
}

console.log(findIndex(["hi","edabit","fgh","abc"], "fgh"));
console.log(findIndex(["Red","blue","Blue","Green"], "blue"));
console.log(findIndex(["a","g","y","d"], "d"));
console.log(findIndex(["Pineapple","Orange","Grape","Apple"], "Pineapple"));

//challenge 8
function absolute(number){
    var absNumber=0;
    if(number < 0){
        absNumber = number * -1;
    }else{
        absNumber = number;
    }

    return absNumber;
}

console.log(absolute(-1.217197940));
console.log(absolute(-12.1320));
console.log(absolute(-544.0));
console.log(absolute(4666));
console.log(absolute(-3.14));
console.log(absolute(250));

//challenge 9
function fiftyThirtyTwenty(income){
    var budget = {
        Needs : income * .5,
        Wants : income * .3,
        Savings : income * .2
    }

    return budget;
}

console.log(fiftyThirtyTwenty(10000));
console.log(fiftyThirtyTwenty(50000));
console.log(fiftyThirtyTwenty(13450));

//challenge 10
function cityFacts(cityFacts){
    var printCityFacts = "";
    var cityObj ={
        name: cityFacts.name,
        population: cityFacts.population,
        continent: cityFacts.continent
    }

    printCityFacts = cityObj.name + " has a population of " + cityObj.population + " and is situated in " + cityObj.continent;

    return printCityFacts;
}

console.log(cityFacts({
    name: "Paris",
    population: "2,140,526",
    continent: "Europe"
}));

console.log(cityFacts({
    name: "Tokyo",
    population: "13,929,286",
    continent: "Asia"
}));