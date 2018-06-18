package cn.caijinbiao.assistant.mapper;

import cn.caijinbiao.assistant.model.Translate;
import cn.caijinbiao.assistant.model.TranslateExample.Criteria;
import cn.caijinbiao.assistant.model.TranslateExample.Criterion;
import cn.caijinbiao.assistant.model.TranslateExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class TranslateSqlProvider {

    public String countByExample(TranslateExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("t_translate");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(TranslateExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("t_translate");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(Translate record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_translate");
        
        if (record.getSource() != null) {
            sql.VALUES("f_source", "#{source,jdbcType=VARCHAR}");
        }
        
        if (record.getTarget() != null) {
            sql.VALUES("f_target", "#{target,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            sql.VALUES("f_type", "#{type,jdbcType=VARCHAR}");
        }
        
        if (record.getIsp() != null) {
            sql.VALUES("f_isp", "#{isp,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExample(TranslateExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("f_id");
        } else {
            sql.SELECT("f_id");
        }
        sql.SELECT("f_source");
        sql.SELECT("f_target");
        sql.SELECT("f_type");
        sql.SELECT("f_isp");
        sql.FROM("t_translate");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Translate record = (Translate) parameter.get("record");
        TranslateExample example = (TranslateExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("t_translate");
        
        if (record.getId() != null) {
            sql.SET("f_id = #{record.id,jdbcType=VARCHAR}");
        }
        
        if (record.getSource() != null) {
            sql.SET("f_source = #{record.source,jdbcType=VARCHAR}");
        }
        
        if (record.getTarget() != null) {
            sql.SET("f_target = #{record.target,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            sql.SET("f_type = #{record.type,jdbcType=VARCHAR}");
        }
        
        if (record.getIsp() != null) {
            sql.SET("f_isp = #{record.isp,jdbcType=VARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("t_translate");
        
        sql.SET("f_id = #{record.id,jdbcType=VARCHAR}");
        sql.SET("f_source = #{record.source,jdbcType=VARCHAR}");
        sql.SET("f_target = #{record.target,jdbcType=VARCHAR}");
        sql.SET("f_type = #{record.type,jdbcType=VARCHAR}");
        sql.SET("f_isp = #{record.isp,jdbcType=VARCHAR}");
        
        TranslateExample example = (TranslateExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Translate record) {
        SQL sql = new SQL();
        sql.UPDATE("t_translate");
        
        if (record.getSource() != null) {
            sql.SET("f_source = #{source,jdbcType=VARCHAR}");
        }
        
        if (record.getTarget() != null) {
            sql.SET("f_target = #{target,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            sql.SET("f_type = #{type,jdbcType=VARCHAR}");
        }
        
        if (record.getIsp() != null) {
            sql.SET("f_isp = #{isp,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("f_id = #{id,jdbcType=VARCHAR}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, TranslateExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}