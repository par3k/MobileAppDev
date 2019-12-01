package com.example.login;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link StatisticsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link StatisticsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StatisticsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public StatisticsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment StatisticsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StatisticsFragment newInstance(String param1, String param2) {
        StatisticsFragment fragment = new StatisticsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private ListView courseListView;
    private StatisticsCourseListAdapter adapter;
    private List<Course> courseList;

    public static int totalCredit = 0;
    public static TextView credit;

    private ArrayAdapter rankAdapter;
    private Spinner rankSpinner;

    private ListView rankListView;
    private RankListAdapter rankListAdapter;
    private List<Course> rankList;


    @Override
    public void onActivityCreated(Bundle b){
        super.onActivityCreated(b);
        courseListView = (ListView) getView().findViewById(R.id.analysisListView);
        courseList = new ArrayList<Course>();
        adapter = new StatisticsCourseListAdapter(getContext().getApplicationContext(), courseList, this);
        courseListView.setAdapter(adapter);
        new BackgroundTask().execute();

        totalCredit =0;
        credit = (TextView) getView().findViewById(R.id.totalCredit);

        rankSpinner = (Spinner) getView().findViewById(R.id.rankSpinner);
        rankAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.rank, R.layout.spinner_item);
        rankSpinner.setAdapter(rankAdapter);
        rankSpinner.setPopupBackgroundResource(R.color.colorPrimary);
        rankListView = (ListView) getView().findViewById(R.id.rankListView);
        rankList = new ArrayList<Course>();
        rankListAdapter = new RankListAdapter(getContext().getApplicationContext(), rankList, this);
        rankListView.setAdapter(rankListAdapter);
        new ByEntire().execute();
        rankSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (rankSpinner.getSelectedItem().equals("ByEntire")) {

                } else if (rankSpinner.getSelectedItem().equals("Male prefer")){

                } else if (rankSpinner.getSelectedItem().equals("Female prefer")) {

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


    class ByEntire extends AsyncTask<Void, Void, String> {
        String target ;
        ProgressDialog dialog = new ProgressDialog(getActivity());

        @Override
        protected void onPreExecute(){

            try{
                target = "https://bakhoijae.cafe24.com/ByEntire.php";
                dialog.setMessage("Loading..");
                dialog.show();
            }catch (Exception e){
                e.printStackTrace();
            }dialog.dismiss();
        }

        @Override
        protected String doInBackground(Void... voids) {
            try{

                URL url = new URL(target);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String temp;
                StringBuilder stringBuilder = new StringBuilder();
                while ((temp = bufferedReader.readLine())!=null){
                    stringBuilder.append(temp + "\n");
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return stringBuilder.toString().trim();
            }catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        public void onProgressUpdate(Void...values){
            super.onProgressUpdate();
        }

        @Override
        public void onPostExecute(String result){
            try{
                JSONObject jsonObject = new JSONObject(result);
                JSONArray jsonArray = jsonObject.getJSONArray("response");
                int count = 0;
                int courseID;
                String courseTitle;
                String courseProfessor;
                int courseCredit;
                int coursePersonnel;
                String courseTime;

                while(count<jsonArray.length()){
                    JSONObject object = jsonArray.getJSONObject(count);
                    courseID = object.getInt("courseID");
                    courseTitle = object.getString("courseTitle");
                    courseCredit = object.getInt("courseCredit");
                    courseProfessor = object.getString("courseProfessor");
                    courseTime = object.getString("courseTime");
                    coursePersonnel = object.getInt("coursePersonnel");
                    rankList.add(new Course(courseID, courseTitle, courseCredit, courseProfessor, courseTime, coursePersonnel));
                    count++;
                }
                rankListAdapter.notifyDataSetChanged();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }



    class BackgroundTask extends AsyncTask<Void, Void, String> {
        String target ;
        ProgressDialog dialog = new ProgressDialog(getActivity());

        @Override
        protected void onPreExecute(){

            try{
                target = "https://bakhoijae.cafe24.com/StatisticsCourseList.php?userID=" + URLEncoder.encode(MainActivity.userID,"UTF-8");
                dialog.setMessage("Loading..");
                dialog.show();
            }catch (Exception e){
                e.printStackTrace();
            }dialog.dismiss();
        }

        @Override
        protected String doInBackground(Void... voids) {
            try{

                URL url = new URL(target);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String temp;
                StringBuilder stringBuilder = new StringBuilder();
                while ((temp = bufferedReader.readLine())!=null){
                    stringBuilder.append(temp + "\n");
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return stringBuilder.toString().trim();
            }catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        public void onProgressUpdate(Void...values){
            super.onProgressUpdate();
        }

        @Override
        public void onPostExecute(String result){
            try{
                JSONObject jsonObject = new JSONObject(result);
                JSONArray jsonArray = jsonObject.getJSONArray("response");
                int count = 0;
                int courseID;
                String courseTitle;
                int courseCredit;
                int coursePersonnel;
                int courseRival;


                while(count<jsonArray.length()){
                    JSONObject object = jsonArray.getJSONObject(count);
                    courseID = object.getInt("courseID");
                    courseTitle = object.getString("courseTitle");
                    courseCredit = object.getInt("courseCredit");
                    coursePersonnel = object.getInt("coursePersonnel");
                    courseRival = object.getInt("COUNT(M_SCHEDULE.courseID)");
                    int courseCredit2 = object.getInt("courseCredit");
                    totalCredit += courseCredit2;
                    courseList.add(new Course(courseID,courseTitle,courseCredit,coursePersonnel,courseRival));
                    count++;
                }
                adapter.notifyDataSetChanged();
                credit.setText(totalCredit + " credit(s)");
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_statistics, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
