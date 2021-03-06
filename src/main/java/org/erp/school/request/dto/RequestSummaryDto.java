package org.erp.school.request.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.erp.school.request.enums.RequestStatus;

import java.time.DayOfWeek;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestSummaryDto {

  private Integer totalRequestsReceived;
  private Map<RequestStatus, Integer> requestsByStatus;
  private Map<DayOfWeek, Integer> newProposalsByDay;

}
