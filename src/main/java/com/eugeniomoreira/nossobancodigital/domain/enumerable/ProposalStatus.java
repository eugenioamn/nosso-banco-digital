package com.eugeniomoreira.nossobancodigital.domain.enumerable;

public enum ProposalStatus {

    PENDING(1), ACCEPTED(2), DENIED(3);

    int n;

    ProposalStatus(int n) {
        this.n = n;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public String getStatus(int n) {
        ProposalStatus[] values = ProposalStatus.values();
        for (ProposalStatus status : values) {
            if (status.n == n) {
                return status.name();
            }
        }

        return null;
    }

}
