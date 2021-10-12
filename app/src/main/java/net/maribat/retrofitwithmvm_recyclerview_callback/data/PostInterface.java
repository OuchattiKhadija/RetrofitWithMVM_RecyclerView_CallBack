package net.maribat.retrofitwithmvm_recyclerview_callback.data;

import net.maribat.retrofitwithmvm_recyclerview_callback.model.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostInterface {
    @GET("posts")
    public Call<List<PostModel>> getPosts();
}
