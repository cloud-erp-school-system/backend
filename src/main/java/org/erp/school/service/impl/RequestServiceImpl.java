package org.erp.school.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.erp.school.dto.RequestSummaryDto;
import org.erp.school.model.RequestStatus;
import org.erp.school.service.RequestService;
import org.erp.school.service.repository.RequestRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashMap;

@Service
@Slf4j
public class RequestServiceImpl implements RequestService {

  private final RequestRepository requestRepository;

  public RequestServiceImpl(RequestRepository requestRepository) {
    this.requestRepository = requestRepository;
  }

  @Transactional
  public RequestSummaryDto getRequestSummary() {
    var requestSummaryDto = new RequestSummaryDto();
    var requestsByStatus = new HashMap<RequestStatus, Integer>();

    var allClientRequests = requestRepository.findAll();

    int totalRequestsReceived = allClientRequests.size();

    var requestStatus = Arrays.asList(RequestStatus.values());
    requestStatus.forEach(status -> requestsByStatus.put(status, 0));

    if (totalRequestsReceived > 0) {
      requestStatus.forEach(
              status ->
                      requestsByStatus.put(
                              status,
                              Math.toIntExact(
                                      allClientRequests.stream()
                                                       .filter(request -> request.getStatus().equals(status))
                                                       .count())));
    }

    // new proposals by day - TO DO
    requestSummaryDto.setTotalRequestsReceived(totalRequestsReceived);
    requestSummaryDto.setRequestsByStatus(requestsByStatus);

    if (log.isDebugEnabled()) {
      log.debug("------- Summary ------");
      log.debug(String.format("Content: %s", requestSummaryDto));
    }

    return requestSummaryDto;
  }
}
