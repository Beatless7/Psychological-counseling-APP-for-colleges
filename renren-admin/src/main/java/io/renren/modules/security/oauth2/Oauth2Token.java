// powered by 天津理工大学心理辅导团队

package io.renren.modules.security.oauth2;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * token
 *
 * @author Tjut team
 */
public class Oauth2Token implements AuthenticationToken {
    private String token;

    public Oauth2Token(String token){
        this.token = token;
    }

    @Override
    public String getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
