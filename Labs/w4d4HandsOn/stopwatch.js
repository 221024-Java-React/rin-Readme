let element = document.getElementById("timer");
let minutes = 0;//document.getElementById("minutes");
let seconds = 0;//document.getElementById("seconds");
let milliseconds = 0;//document.getElementById("milliseconds");
document.getElementById("start").addEventListener("click", startTimer);
document.getElementById("stop").addEventListener("click", stopTimer);
document.getElementById("reset").addEventListener("click", resetTimer);

function startTimer(){
    interval = setInterval(()=> {
        milliseconds++;
        if(milliseconds==100){
            milliseconds = 0;
            seconds++;
            
        }
        if(seconds==60){
            seconds=0;
            minutes++;
        }

        document.getElementById("minutes").innerText = minutes;
        document.getElementById("seconds").innerText = seconds;
        document.getElementById("milliseconds").innerText = milliseconds;
        //console.log(minutes);
        //console.log(seconds);
        //console.log(milliseconds);
    },.001); 
}

function startInterval(){
    document.getElementById("sound1").play();
    interval = setInterval(()=> {
        let body = document.getElementsByTagName("body")[0];
        body.setAttribute("style", `background-color: ${disco()}`);
    }, 100);
}

function stopTimer(){
    clearInterval(interval);
}

function resetTimer(){
    milliseconds=0;
    seconds=0;
    minutes=0;
    document.getElementById("minutes").innerText = minutes;
    document.getElementById("seconds").innerText = seconds;
    document.getElementById("milliseconds").innerText = milliseconds;
}