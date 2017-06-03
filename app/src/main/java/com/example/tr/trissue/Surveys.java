package com.example.tr.trissue;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tapali on 03/06/17.
 */

public class Surveys extends Fragment{

    private RecyclerView mSurveysRecyclerView;
    private SurveysAdapter mAdapter;
    private String address_id;
    private List<Survey> mSurveys = new ArrayList<>();

    public static Surveys newInstance(String address_id){
        Surveys surveys = new Surveys();
        Bundle bundle = new Bundle();
        bundle.putString("address_id", address_id);
        surveys.setArguments(bundle);
        return surveys;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        address_id = getArguments().getString("address_id");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_surveys, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mSurveysRecyclerView = (RecyclerView) view
                .findViewById(R.id.survey_recycler_view);
        mSurveysRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new SurveysAdapter(mSurveys);
        mSurveysRecyclerView.setAdapter(mAdapter);
        updateUI();
    }

    private void updateUI() {
        List<Survey> ss = new ArrayList<>();

        ss.add(new Survey("id1", "abc"));
        ss.add(new Survey("id2", "xyz"));

        mSurveys.clear();
        mSurveys.addAll(ss);
        mAdapter.notifyDataSetChanged();

        //updateSubtitle();
    }

    private class SurveyHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        private Survey mSurvey;

        private TextView mSurvey_id;
        private TextView mSurvey_name;

        public SurveyHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_survey, parent, false));
            itemView.setOnClickListener(this);

            mSurvey_id = (TextView) itemView.findViewById(R.id.survey_id);
            mSurvey_name = (TextView) itemView.findViewById(R.id.survey_name);
        }

        public void bind(Survey survey) {
            mSurvey = survey;
            mSurvey_id.setText(mSurvey.getSurvey_id());
            mSurvey_name.setText(mSurvey.getSurvey_name());
        }

        @Override
        public void onClick(View view) {
            //Intent intent = CrimePagerActivity.newIntent(getActivity(), mCrime.getId());
            //startActivity(intent);
        }
    }

    private class SurveysAdapter extends RecyclerView.Adapter<SurveyHolder> {

        private List<Survey> mSurveys;

        public SurveysAdapter(List<Survey> surveys) {
            mSurveys = surveys;
        }

        @Override
        public SurveyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            return new SurveyHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(SurveyHolder holder, int position) {
            Survey survey = mSurveys.get(position);
            holder.bind(survey);
        }

        @Override
        public int getItemCount() {
            return mSurveys.size();
        }

        public void setSurveys(List<Survey> surveys) {
            mSurveys = surveys;
        }
    }
}
