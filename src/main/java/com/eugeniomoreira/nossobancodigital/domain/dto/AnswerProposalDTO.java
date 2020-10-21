package com.eugeniomoreira.nossobancodigital.domain.dto;

public class AnswerProposalDTO {

    private Long proposalId;

    private String message;

    public AnswerProposalDTO() {
    }

    public AnswerProposalDTO(Long proposalId, String message) {
        this.proposalId = proposalId;
        this.message = message;
    }

    public Long getProposalId() {
        return proposalId;
    }

    public void setProposalId(Long proposalId) {
        this.proposalId = proposalId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
