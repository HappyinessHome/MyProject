$(function(){
    function Time(){
        var myDate = new Date();
        var Year = myDate.getFullYear();
        var Month = myDate.getMonth()+1;
        var Day = myDate.getDate();
        var H = myDate.getHours();
        if(H<10){
            H="0"+H;
        }
        var M =myDate.getMinutes();
        if(M<10){
            M="0"+M;
        }
        var S = myDate.getSeconds();
        if(S<10){
            S="0"+S;
        }
        var time = Year+'-'+Month+'-'+Day
        var date = H+':'+M+':'+S
        $('.header-right>.day').html(time);
        $('.header-right>.time').html(date);
    }
    sobj = setInterval(Time, 0);
})