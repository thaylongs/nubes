package mock.controllers.views;

import io.vertx.ext.apex.RoutingContext;
import io.vertx.mvc.annotations.Controller;
import io.vertx.mvc.annotations.View;
import io.vertx.mvc.annotations.params.Params;
import io.vertx.mvc.annotations.routing.Path;
import io.vertx.mvc.controllers.AbstractController;
import mock.domains.Dog;

@Controller("/views")
public class ViewTestController extends AbstractController {
	
	@Path("/default")
	@View("index.html")
	public void rootView(RoutingContext context) {
		context.next();
	}
	
	@Path("/handlebars")
	@View("dog-name.hbs")
	public void handlebarsView(RoutingContext context, @Params Dog dog) {
		context.data().put("dog", dog);
		context.next();
	}
	
	@Path("/mvel")
	@View("dog-name.templ")
	public void mvelView(RoutingContext context, @Params Dog dog) {
		context.data().put("dog", dog);
		context.next();
	}
}
