package fr.STB1;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import fr.STB1.config.AppConfig;

public class ServeletInitializer extends
AbstractAnnotationConfigDispatcherServletInitializer {
  @Override
  protected Class<?>[] getRootConfigClasses() {
         return new Class<?>[0];
  }
  
  @Override
  protected Class<?>[] getServletConfigClasses() {
         return new Class<?>[]{AppConfig.class};
  }
  @Override
  protected String[] getServletMappings() {
         return new String[]{"/"};
  }
}
