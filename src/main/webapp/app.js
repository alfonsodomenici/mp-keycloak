console.log("start app.....");

export var keycloak = Keycloak('./keycloak.json');
keycloak
        .init({
            onLoad: 'login-required'
        })
        .then(authenticated => {
            alert(authenticated ? 'authenticated' : 'not authenticated');
            console.log('token parsed: ' + JSON.stringify(keycloak.tokenParsed));
            console.log('----------------------------');
            console.log(JSON.stringify(keycloak.token));
        })
        .catch(error => {
            alert('failed to initialize');
            console.log(error);
        });
