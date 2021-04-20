package org.erp.school.client.child.request.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.erp.school.client.child.request.dto.RequestSummaryDto;
import org.erp.school.client.child.request.enums.RequestStatus;
import org.erp.school.client.child.request.service.RequestService;
import org.erp.school.client.child.request.repository.RequestRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.EnumMap;

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
    var requestsByStatus = new EnumMap<RequestStatus, Integer>(RequestStatus.class);

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
