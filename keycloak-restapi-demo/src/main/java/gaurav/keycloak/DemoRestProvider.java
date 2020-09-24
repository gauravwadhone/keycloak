package gaurav.keycloak;

import gaurav.keycloak.model.UserDetails;
import org.jboss.resteasy.annotations.cache.NoCache;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.UserModel;
import org.keycloak.services.resource.RealmResourceProvider;
import org.keycloak.utils.MediaType;

import javax.ws.rs.Encoded;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;
import java.util.stream.Collectors;

public class DemoRestProvider implements RealmResourceProvider {
    private final KeycloakSession session;


    public DemoRestProvider(KeycloakSession session) {
        this.session = session;
    }


    public void close() {

    }

    public Object getResource() {
        return this;
    }

    @GET
    @Path("users")
    @NoCache
    @Produces({MediaType.APPLICATION_JSON})
    @Encoded
    public List<UserDetails> getUsers() {
        List<UserModel> userModel = session.users().getUsers(session.getContext().getRealm());
        return userModel.stream().map(e -> toUserDetail(e)).collect(Collectors.toList());
    }

    private UserDetails toUserDetail(UserModel um) {
        return new UserDetails(um.getUsername(), um.getFirstName(), um.getLastName());

    }

}
