package example.micronaut

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces

@Controller("/api/registration/hello") // <1>
class HelloController {

	@Get// <2>
	//@Produces(MediaType.TEXT_PLAIN) // <3>
	fun index(): String {
		return "Hello World from registration-srv!" // <4>
	}
}
