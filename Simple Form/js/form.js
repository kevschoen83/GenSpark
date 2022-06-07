function showtext() {
    var fname = document.getElementById('fname').value;
    var lname = document.getElementById('lname').value;
    var phonenumber = document.getElementById('phonenumber').value;
    var email = document.getElementById('email').value;
    var occ = document.getElementById('occ').value;
    var country = document.getElementById('country').value;
    var comment = document.getElementById('comment').value;

    document.getElementById("show").innerHTML = fname + "<br>" + lname + "<br>" + phonenumber + "<br>" + 
    email + "<br>" + occ + "<br>" + country + "<br>" + comment;
}