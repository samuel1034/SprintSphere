package org.dasher.speed.project.ui.view;

import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;


@Route("projects")
@PageTitle("projects")
@Menu(order = 1, icon = "vaadin:briefcase", title = "Projects")
public class ProjectsView extends Main {
    public ProjectsView () {
        Grid<Person> grid = new Grid<>(Person.class, false);
        grid.addColumn(createAvatarRenderer()).setHeader("Image")
                .setAutoWidth(true).setFlexGrow(0);
        grid.addColumn(Person::getFirstName).setHeader("First name");
        grid.addColumn(Person::getLastName).setHeader("Last name");
        grid.addColumn(Person::getEmail).setHeader("Email");

        grid.addThemeVariants(GridVariant.LUMO_ROW_STRIPES);
    }
}
