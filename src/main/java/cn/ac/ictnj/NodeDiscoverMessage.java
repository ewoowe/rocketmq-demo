package cn.ac.ictnj;

enum NodeType {
    CN_TP_Nokia_FDDLTE,
    CN_TP_Nokia_5GNR,
    AN_TP_Nokia_FDDLTE,
    AN_TP_Nokia_5GNR,
    AN_ICTNJ_FDDLTE,
    AN_ICTNJ_5GNR,
    AN_ICTNJ_NORMAL
}

public class NodeDiscoverMessage {
    private String nodeId;
    private String ip;
    private NodeType type;

    public NodeDiscoverMessage(String nodeId, String ip, NodeType type) {
        this.nodeId = nodeId;
        this.ip = ip;
        this.type = type;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public NodeType getType() {
        return type;
    }

    public void setType(NodeType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "NodeDiscoverMessage{" +
                "nodeId='" + nodeId + '\'' +
                ", ip='" + ip + '\'' +
                ", type=" + type +
                '}';
    }
}
