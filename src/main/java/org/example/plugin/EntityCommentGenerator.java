package org.example.plugin;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.internal.util.StringUtility;

import java.text.SimpleDateFormat;
import java.util.Properties;

/**
 *
 */
public class EntityCommentGenerator implements CommentGenerator {
    private final Properties properties = new Properties();
    private boolean suppressDate = false;
    private boolean suppressAllComments = false;
    private boolean addRemarkComments = false;
    private SimpleDateFormat dateFormat;

    @Override
    public void addConfigurationProperties(Properties properties) {
        this.properties.putAll(properties);
        this.suppressDate = StringUtility.isTrue(this.properties.getProperty("suppressDate"));
        this.suppressAllComments = StringUtility.isTrue(this.properties.getProperty("suppressAllComments"));
        this.addRemarkComments = StringUtility.isTrue(this.properties.getProperty("addRemarkComments"));
        String dateFormatString = this.properties.getProperty("dateFormat");
        if (StringUtility.stringHasValue(dateFormatString)) {
            this.dateFormat = new SimpleDateFormat(dateFormatString);
        }
    }

    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        if (suppressAllComments) {
            return;
        }
        if (StringUtility.stringHasValue(introspectedColumn.getRemarks())) {
            field.addJavaDocLine("/** " + introspectedColumn.getRemarks() + " */");
        }
    }


    @Override
    public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        if (suppressAllComments) {
            return;
        }

        if (StringUtility.stringHasValue(introspectedTable.getRemarks())) {
            topLevelClass.addJavaDocLine("/**");
            topLevelClass.addJavaDocLine(" * " + introspectedTable.getRemarks());
            topLevelClass.addJavaDocLine(" */");
        }
    }
}
