package com.networth.repo;

import java.io.IOException;
import java.nio.charset.Charset;

import com.networth.infra.exception.ApiException;
import com.networth.infra.exception.ApiExceptionType;
import com.networth.infra.utils.JsonUtils;
import com.networth.models.LineItemsContainer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;
import org.springframework.util.StreamUtils;

@Repository
public class DefaultNetWorthRepository implements NetWorthRepository {

    private Resource jsonFile;

    public DefaultNetWorthRepository(@Value("classpath:data.json") Resource jsonFile) {
        this.jsonFile = jsonFile;
    }

    @Override
    public LineItemsContainer getLineItemsContainer() {
        try {
            String json = StreamUtils.copyToString(jsonFile.getInputStream(), Charset.defaultCharset());
            return JsonUtils.fromJson(json, LineItemsContainer.class);
        } catch (IOException e) {
            throw new ApiException(ApiExceptionType.DB, "LINE-ITEM-LOADING-FAILED", "Failed to get line items");
        }
    }

}
