package com.example.tr.trissue;

/**
 * Created by tapali on 03/06/17.
 */

class Survey {

    public Survey(String id, String name) {
        this.survey_id = id;
        this.survey_name = name;
    }

    public String getSurvey_id() {
        return survey_id;
    }

    public void setSurvey_id(String survey_id) {
        this.survey_id = survey_id;
    }

    String survey_id;

    public String getSurvey_name() {
        return survey_name;
    }

    public void setSurvey_name(String survey_name) {
        this.survey_name = survey_name;
    }

    String survey_name;



}
