
    function validerPhoneno(){
    const phoneNo = $("#phoneNo").val();
    const regexp = /^[0-9]{8}$/;
    const ok = regexp.test(phoneNo);

    if(!ok){
    $("#wrongPhoneNo").html("Phone number should be 8 digits long");
    return false;
} else{
    $("#wrongPhoneNo").html("");
    return true;
}
}

    function validerEmail(){
    const email = $("#email").val();
    const regexp = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    const ok = regexp.test(email);

    if(!ok){
    $("#wrongEmail").html("You have to enter a valid email");
    return false;
} else{
    $("#wrongEmail").html("");
    return true;
}
}

function sendForm() {
    const citizen = {
        firstname: $("#firstname").val(),
        surname: $("#surname").val(),
        DoB: $("#dateOfBirth").val(),
        SSN: $("#SSN").val(),
        phoneNo: $("#phoneNo").val(),
        email: $("#email").val(),
        city: $("#city").val(),
        street: $("#street").val()

    };

    console.log(citizen)

    if (validerFirstname() && validerSurname() && validerDoB() && validerSSN()
        && validerPhoneno() && validerEmail() && validerCity() && validerStreet()) {
        $.post("/saveCitizen", citizen, function () {


        })
            .fail(function (jqXHR) {
                const json = $.parseJSON(jqXHR.responseText);
                $("#feil").html(json.message)
            })
    }
}