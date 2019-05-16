package com.commerce.backend.api;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.commerce.backend.dto.UploadFileDTO;
import com.commerce.backend.utils.UploadFileUtils;

@RestController
public class UploadFileApi extends ApiController {

	@Autowired
	private UploadFileUtils uploadFileUtils;

	@PostMapping(value = "/uploadFile")
	public ResponseEntity<Object> uploadFile(@RequestBody UploadFileDTO uploadFileDTO) {

		try {
			byte[] decodeBase64 = Base64.getDecoder().decode(uploadFileDTO.getBase64().getBytes());
			uploadFileUtils.writeOrUpdate(decodeBase64, "/thumbnail/" + uploadFileDTO.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
