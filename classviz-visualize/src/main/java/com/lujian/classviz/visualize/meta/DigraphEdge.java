package com.lujian.classviz.visualize.meta;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@EqualsAndHashCode
@NoArgsConstructor
public class DigraphEdge {

    DigraphNode source;

    List<DigraphNode> targetList = new ArrayList<>();

    public DigraphEdge(DigraphNode source) {
        this.source = source;
    }

    public DigraphEdge(DigraphNode source, List<DigraphNode> targetList) {
        this.source = source;
        this.targetList = targetList;
    }

    public void addTarget(DigraphNode target) {
        targetList.add(target);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DigraphEdge that = (DigraphEdge) o;
        return Objects.equals(source, that.source) &&
                Objects.equals(targetList, that.targetList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(source, targetList);
    }
}
