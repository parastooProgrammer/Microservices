package com.selfstudy.accounts.controller;

import com.selfstudy.accounts.constants.AccountConstant;
import com.selfstudy.accounts.dto.CustomerDto;
import com.selfstudy.accounts.dto.ErrorResponseDto;
import com.selfstudy.accounts.dto.ResponseDto;
import com.selfstudy.accounts.service.IAccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;

@Tag(
        name=" crud account",
        description = "*******"
)
@RestController
@RequestMapping(path = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
@Validated
public class AccountController {

    private IAccountService iAccountService;

    @GetMapping("sayHello")
    public String sayHello() {
        return "Hello Wolrd";
    }

    /**
     *
     * @param customerDto
     * @return
     */
    @Operation(
            summary = "to create an account",
            description = "*******"
    )
    @ApiResponse(
            responseCode = "201",
            description = "*****"
    )
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccount(@Valid @RequestBody CustomerDto customerDto) {
        iAccountService.createAccount(customerDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDto(AccountConstant.STATUS_201,
                        AccountConstant.MESSAGE_201));
    }

    /**
     *
     * @param mobileNumber
     * @return
     */
    @GetMapping("/fetch")
    public ResponseEntity<CustomerDto> fetchAccountDetails(@RequestParam
                                                           @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile number must be 10 digits")
                                                           String mobileNumber) {
        CustomerDto customerDto = iAccountService.fetchAccount(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(customerDto);
    }

    /**
     *
     * @param customerDto
     * @return
     */
    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateAccountDetails(@Valid@RequestBody CustomerDto customerDto) {
        boolean isUpdated = iAccountService.updateAccount(customerDto);
        if(isUpdated) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(AccountConstant.STATUS_200, AccountConstant.MESSAGE_200));
        }else{
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(AccountConstant.STATUS_500, AccountConstant.MESSAGE_417_UPDATE));
        }
    }

    /**
     *
     * @param mobileNumber
     * @return
     */
    @Operation(
            summary = "to delete an account",
            description = "*******"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "417",
                    description = "Expectation Failed"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    }
    )
    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteAccountDetails(@RequestParam
                                                            @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile number must be 10 digits")
                                                            String mobileNumber) {
        boolean isDeleted = iAccountService.deleteAccount(mobileNumber);
        if(isDeleted) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(AccountConstant.STATUS_200, AccountConstant.MESSAGE_200));
        }else{
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(AccountConstant.STATUS_500, AccountConstant.MESSAGE_417_DELETE));
        }
    }
}
