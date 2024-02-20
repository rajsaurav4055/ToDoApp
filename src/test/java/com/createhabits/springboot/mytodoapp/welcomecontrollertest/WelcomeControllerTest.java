package com.createhabits.springboot.mytodoapp.welcomecontrollertest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ModelMap;

import com.createhabits.springboot.mytodoapp.login.WelcomeController;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WelcomeControllerTest {

    @Test
    public void testGotoWelcomePage() {
    	WelcomeController controller = new WelcomeController();
        ModelMap model = new ModelMap();
        Authentication authentication = mock(Authentication.class);
        when(authentication.getName()).thenReturn("TestUser");
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String result = controller.gotoWelcomePage(model);

        assertEquals("welcome", result);
        assertEquals("TestUser", model.get("name"));
    }
}

