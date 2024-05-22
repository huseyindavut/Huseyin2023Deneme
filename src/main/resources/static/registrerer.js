function sendForm() {
    const citizen={
        firstName: $("#firstName").val(),
        surname:$("#surname").val(),
        doB:$("#doB").val(),
        SSN: $("#SSN").val(),
        phoneNr:$("#number").val(),
        email:$("#mail").val(),
        city:$("#city").val(),
        street:$("#street").val()
    }
    console.log(citizen);
    if(validerNummer() && validerEpost() ){
        $.post("/saveCitizen", citizen, function () {

        })
            .fail(function (jqXHR) {
                const json=$.parseJSON(jqXHR.respondText);
                $("#fail").html(json.message)
            })
    }
}

function validerNummer() {
    const number = $("#number").val();
    const regexp = /^[0-9]{8}$/;
    const ok = regexp.test(number);
    if(!ok){
        $("#feilNumber").html("Phone number number must consist of 8 digits");
        return false;
    }
    else{
        $("#feilNumber").html("");
        return true;
    }
}
function validerEpost() {
    const email = $("#mail").val();
    const regexp = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    const ok = regexp.test(email);
    if(!ok){
        $("#feilEmail").html("Enter the email address in the correct format (e.g. ca@ca.ca)");
        return false;
    }
    else{
        $("#feilEmail").html("");
        return true;
    }
}
function removeUnderAge(){
    $.get("/removeUnderage",function (OK){
        $("#fail").html("Under 18 citizens removed")

    })
        .fail(function (jqXHR) {
            const json=$.parseJSON(jqXHR.respondText);
            $("#fail").html(json.message)
        })
}
function loggOut() {
    $.get("/logout", function () {
        window.location.href="index.html";
    })
}

