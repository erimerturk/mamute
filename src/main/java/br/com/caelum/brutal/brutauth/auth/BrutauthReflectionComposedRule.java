package br.com.caelum.brutal.brutauth.auth;

import br.com.caelum.brutal.auth.rules.ComposedRule;
import br.com.caelum.brutal.auth.rules.PermissionRule;
<<<<<<< HEAD
import br.com.caelum.brutal.brutauth.auth.rules.BrutauthRule;
import br.com.caelum.brutal.brutauth.auth.rules.CustomBrutauthRule;
import br.com.caelum.brutal.brutauth.reflection.DefaultMethodInvoker;

public class BrutauthReflectionComposedRule implements BrutauthRule {
=======
import br.com.caelum.brutal.brutauth.auth.rules.CustomBrutauthRule;
import br.com.caelum.brutal.brutauth.reflection.DefaultMethodInvoker;

public class BrutauthReflectionComposedRule {
>>>>>>> 255f1e479d9e262cc07cbd1ffc7ecc0bdfc3c159
		
		private CustomBrutauthRule current;
		private final DefaultMethodInvoker invoker;
	
		public BrutauthReflectionComposedRule(CustomBrutauthRule first, DefaultMethodInvoker invoker) {
			this.current = first;
			this.invoker = invoker;
		}
		
		public BrutauthReflectionComposedRule and(CustomBrutauthRule second) {
			current = new AndRule(current, second, invoker);
			return this;
		}
		
		public boolean isAllowed(Object...args) {
			return invoker.invoke(current, args);
		}

		public static <T> ComposedRule<T> composedRule(PermissionRule<T> first) {
			return new ComposedRule<>(first);
		}

		public static class AndRule implements CustomBrutauthRule {
			private final CustomBrutauthRule second;
			private final CustomBrutauthRule first;
			private final DefaultMethodInvoker invoker;
			
			public AndRule(CustomBrutauthRule first, CustomBrutauthRule second, DefaultMethodInvoker invoker) {
				this.first = first;
				this.second = second;
				this.invoker = invoker;
			}
			
			public boolean isAllowed(Object...objects) {
				return invoker.invoke(first, objects) && invoker.invoke(second, objects);
			}
		}

}
