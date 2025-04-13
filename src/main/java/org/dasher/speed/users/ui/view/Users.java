package org.dasher.speed.users.ui.view;

import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.Route;

@Route("users")
@Menu(order = 2, icon = "vaadin:users", title = "Users")
public class Users extends Main {
    public Users () {
       setText("Users View");
    }
}
