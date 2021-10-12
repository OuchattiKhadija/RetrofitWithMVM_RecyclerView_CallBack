package net.maribat.retrofitwithmvm_recyclerview_callback.ui.main;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import net.maribat.retrofitwithmvm_recyclerview_callback.R;
import net.maribat.retrofitwithmvm_recyclerview_callback.model.PostModel;
import net.maribat.retrofitwithmvm_recyclerview_callback.ui.adapter.PostsAdapter;
import net.maribat.retrofitwithmvm_recyclerview_callback.ui.viewmodel.PostViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    PostViewModel postViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        postViewModel = ViewModelProviders.of(this).get(PostViewModel.class);

        postViewModel.getPosts();
        RecyclerView recyclerView = findViewById(R.id.recycler);
        final PostsAdapter adapter = new PostsAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


        postViewModel.postsMutableLiveData.observe(this, new Observer<List<PostModel>>() {
            @Override
            public void onChanged(List<PostModel> postModels) {
                adapter.setList(postModels);
            }
        });
    }
}