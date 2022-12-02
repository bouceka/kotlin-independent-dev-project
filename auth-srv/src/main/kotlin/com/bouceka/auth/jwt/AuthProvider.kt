package com.bouceka.auth.jwt

import java.util.ArrayList;

import jakarta.inject.Singleton;

import org.reactivestreams.Publisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.http.HttpRequest;
import io.micronaut.security.authentication.AuthenticationException;
import io.micronaut.security.authentication.AuthenticationFailed;
import io.micronaut.security.authentication.AuthenticationProvider;
import io.micronaut.security.authentication.AuthenticationRequest;
import io.micronaut.security.authentication.AuthenticationResponse;
import reactor.core.publisher.Flux
import reactor.core.publisher.FluxSink

@Singleton
class AuthenticationProviderUserPassword : AuthenticationProvider {

	override fun authenticate(
		httpRequest: HttpRequest<*>?,
		authenticationRequest: AuthenticationRequest<*, *>
	): Publisher<AuthenticationResponse> {
		return Flux.create({ emitter: FluxSink<AuthenticationResponse> ->
			if (authenticationRequest.identity == "sherlock" && authenticationRequest.secret == "secret") { // TODO: Implement real data checker
				emitter.next(AuthenticationResponse.success(authenticationRequest.identity as String))
				emitter.complete()
			} else {
				emitter.error(AuthenticationResponse.exception("Wrong username or password"))
			}
		}, FluxSink.OverflowStrategy.ERROR)
	}
}

