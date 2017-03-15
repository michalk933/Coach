import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.configuration.ConfigurationApp;

public class ConfDispatcher extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[]{ConfigurationApp.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}

}
