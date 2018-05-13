(function() {
    $(init);
    var $userName;
    var $firstName;
    var $lastName;
    var $password;
    var $role;
    var $phone;
    var $email;
    var $dob;
    var $updateBtn;
    
    var userService = new UserServiceClient();

    function init() {
    	$userName = $("#userName");
    	$password = $("#inputPassword");
        $firstName = $("#firstName");
        $lastName = $("#lastName");
        $role = $("#role");
        $phone = $("#phone");
        $email = $("#email");
        $dob = $("#dob");
        
        $updateBtn = $("#updateBtn")
        .click(updateUser);
        
        findUserById(62);
    }
    
    function updateUser() {
        var user = {
            firstName: $firstName.val(),
            lastName: $lastName.val(),
            password: $password.val(),
            email: $email.val(),
            phone: $phone.val(),
            dob: $dob.val()
        };

        userService
            .updateUser(62, user)
            .then(success);
    }
    
    function success(response) {
        if(response === null) {
            alert('unable to update')
        } else {
            alert('success');
        }
    }
    
    function findUserById(userId) {
        userService
            .findUserById(userId)
            .then(renderUser);
    }
    
    function renderUser(user) {
        console.log(user);
        $userName.val(user.username);
        $firstName.val(user.firstName);
        $lastName.val(user.lastName);
        $role.val(user.role);
        $phone.val(user.phone);
        $email.val(user.email);
        $dob.val(user.dob);
    }
})();