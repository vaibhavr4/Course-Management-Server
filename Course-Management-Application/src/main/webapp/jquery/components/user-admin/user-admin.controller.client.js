//IIFE
(function () {

    jQuery(main);

    var tbody;
    var template;
    var userService = new UserServiceClient()
    
    function main() {
        tbody = $('tbody');
        template = $('.template');
        $('#createUser').click(createUser);
        findAllUsers();
    }

    
    function findAllUsers() {
        userService
            .findAllUsers()
            .then(renderUsers);
    }
    
    function createUser() {
        console.log('createUser');

        var username = $('#usernameFld').val();
        var password = $('#passwordFld').val();
        var firstName = $('#firstNameFld').val();
        var lastName = $('#lastNameFld').val();

        var user = {
            username: username,
            password: password,
            firstName: firstName,
            lastName: lastName
        };
        
        userService
        .createUser(user)
        .then(findAllUsers);
    }

    function renderUsers(users) {
        for(var i=0; i<users.length; i++) {
            var user = users[i];
            var clone = template.clone();
            clone.find('.username')
                .html(user.username);
            clone.find('.password')
            .html(user.password);
            clone.find('.firstName')
            .html(user.firstName);
            clone.find('.lastName')
            .html(user.lastName);
            tbody.append(clone);
        }
    }
    
    $('table td').each(function(){
        var $this = $(this);
        if ($this.find('.password')) 
        	{
        	$this.hide();
        	}
    })
})();

