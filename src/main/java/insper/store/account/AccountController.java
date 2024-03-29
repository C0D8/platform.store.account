package insper.store.account;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.cloud.openfeign.FeignClient;


@FeignClient(name = "store-account")
public interface AccountController {

    @PostMapping("/accounts")
    public ResponseEntity<AccountOut> create(
        @RequestBody(required = true) AccountIn in
    );

    @PutMapping("/accounts/{id}")
    public ResponseEntity<AccountOut> update(
        @PathVariable(required = true) String id,
        @RequestBody(required = true) AccountIn in
    );

    @PostMapping("/accounts/auth")
    public ResponseEntity<AccountOut> auth(
        @RequestBody(required = true) AuthIn in
    );    

   @GetMapping("/accounts")
    public ResponseEntity<AccountOut> read(
        @RequestHeader(required = true, name = "id-user") String idUser,
        @RequestHeader(required = true, name = "role-user") String roleUser
    );

    
}