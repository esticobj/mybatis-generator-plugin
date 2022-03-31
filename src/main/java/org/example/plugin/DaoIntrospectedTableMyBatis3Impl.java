package org.example.plugin;

import java.util.ArrayList;
import java.util.List;
import org.mybatis.generator.api.GeneratedXmlFile;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.codegen.mybatis3.IntrospectedTableMyBatis3Impl;

public class DaoIntrospectedTableMyBatis3Impl extends IntrospectedTableMyBatis3Impl {

    protected void calculateXmlAttributes() {
        super.calculateXmlAttributes();
        this.setCountByExampleStatementId("countByCriteria");
        this.setDeleteByExampleStatementId("deleteByCriteria");
        this.setSelectByExampleStatementId("selectByCriteria");
        this.setSelectByExampleWithBLOBsStatementId("selectByCriteriaWithBLOBs");
        this.setUpdateByExampleStatementId("updateByCriteria");
        this.setUpdateByExampleSelectiveStatementId("updateByCriteriaSelective");
        this.setUpdateByExampleWithBLOBsStatementId("updateByCriteriaWithBLOBs");
    }

    protected void calculateJavaClientAttributes() {
        super.calculateJavaClientAttributes();
        if (this.context.getJavaClientGeneratorConfiguration() != null) {
            StringBuilder sb = new StringBuilder();
            sb.setLength(0);
            sb.append(this.calculateJavaClientInterfacePackage());
            sb.append('.');
            sb.append(this.fullyQualifiedTable.getDomainObjectName());
            sb.append("Dao");
            this.setMyBatis3JavaMapperType(sb.toString());
        }
    }

    protected void calculateModelAttributes() {
        super.calculateModelAttributes();
        String pakkage = this.calculateJavaModelPackage();
        StringBuilder sb = new StringBuilder();
        sb.setLength(0);
        sb.append(pakkage);
        sb.append('.');
        sb.append(this.fullyQualifiedTable.getDomainObjectName());
        sb.append("Criteria");
        this.setExampleType(sb.toString());
    }

    public List<GeneratedXmlFile> getGeneratedXmlFiles() {
        List<GeneratedXmlFile> answer = new ArrayList();
        if (this.xmlMapperGenerator != null) {
            Document document = this.xmlMapperGenerator.getDocument();
            GeneratedXmlFile gxf = new GeneratedXmlFile(document, this.getMyBatis3XmlMapperFileName(), this.getMyBatis3XmlMapperPackage(), this.context.getSqlMapGeneratorConfiguration().getTargetProject(), false, this.context.getXmlFormatter());
            if (this.context.getPlugins().sqlMapGenerated(gxf, this)) {
                answer.add(gxf);
            }
        }

        return answer;
    }
}
