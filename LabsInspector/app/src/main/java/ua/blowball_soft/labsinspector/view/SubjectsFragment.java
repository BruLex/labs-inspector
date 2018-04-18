package ua.blowball_soft.labsinspector.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ua.blowball_soft.labsinspector.R;
import ua.blowball_soft.labsinspector.adapter.LabsInspListAdapter;
import ua.blowball_soft.labsinspector.dto.LabsInspDTO;

/**
 * Created by Nikita Kamak on 03.02.2018.
 */

public class SubjectsFragment extends Fragment {

    public static final String TAG = "SubjectsFragmentTag";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_subjects, container, false);

        RecyclerView rv = v.findViewById(R.id.subject_recycleView);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(new LabsInspListAdapter(createMockLabsInspData(), getContext()));
        return v;
    }

    private List<LabsInspDTO> createMockLabsInspData() {
        List<LabsInspDTO> data = new ArrayList<>();
        data.add(new LabsInspDTO("Subject 1"));
        data.add(new LabsInspDTO("Subject 2"));
        data.add(new LabsInspDTO("Subject 3"));
        data.add(new LabsInspDTO("Subject 4"));
        data.add(new LabsInspDTO("Subject 5"));
        data.add(new LabsInspDTO("Subject 6"));
        data.add(new LabsInspDTO("Subject 7"));
        data.add(new LabsInspDTO("Subject 8"));
        data.add(new LabsInspDTO("Subject 9"));
        return data;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
    
}
