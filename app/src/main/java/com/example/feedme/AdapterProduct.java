package com.example.feedme;
import android.content.Context;
import android.database.DataSetObserver;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
public class AdapterProduct implements ListAdapter  {

        ArrayList<ObjectForList> arrayList;
        Context context;
        public static String save;
    public  StorageReference storageReference;
    public  FirebaseStorage storage;
    ListView List;
    public static String id_of_business_item;
    public static String num_item;

        public AdapterProduct(Context context, ArrayList<ObjectForList> arrayList, ListView List) {
            this.arrayList=arrayList;
            this.context=context;
            this.List=List;



        }
        @Override
        public boolean areAllItemsEnabled() {
            return false;
        }
        @Override
        public boolean isEnabled(int position) {
            return true;
        }
        @Override
        public void registerDataSetObserver(DataSetObserver observer) {
        }
        @Override
        public void unregisterDataSetObserver(DataSetObserver observer) {
        }
        @Override
        public int getCount() {
            return arrayList.size();
        }
        @Override
        public Object getItem(int position) {
            return position;
        }
        @Override
        public long getItemId(int position) {
            return position;
        }
        @Override
        public boolean hasStableIds() {
            return false;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            storage= FirebaseStorage.getInstance();  //31
            storageReference=storage.getReference();  //31
            ObjectForList subjectData = arrayList.get(position);
            System.out.println("subjectData==="+subjectData.text+","+subjectData.image);
            if(convertView == null) {
                LayoutInflater layoutInflater = LayoutInflater.from(context);
                convertView = layoutInflater.inflate(R.layout.listproduct, null);
                convertView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println("click");
                        String item=subjectData.text;//This will give you the same result of viewHolder.LL.setOnClickListener as you are doing
                        System.out.println("itemmmmmm===="+item);
                         id_of_business_item=Options.id_func(item,"id_of_business=");
                         num_item=Options.id_func(item,"Num of Product=");


                    }
                });
                TextView tittle = convertView.findViewById(R.id.Title);
                ImageView imag = convertView.findViewById(R.id.listview_images);
                System.out.println("subjectData.image"+subjectData.image);
                storageReference.child("images/" + subjectData.image).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        System.out.println(uri.toString() + "************Adapter********************");
                        save = uri.toString();
                        System.out.println(save + "*****************saveAdapter***************");
                        tittle.setText(subjectData.text);
                        Picasso.with(context)
                                .load(save)
                                .into(imag);

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        // Handle any errors
                    }
                });

            }
            return convertView;
        }
        @Override
        public int getItemViewType(int position) {
            return position;
        }
        @Override
        public int getViewTypeCount() {
            return arrayList.size();
        }
        @Override
        public boolean isEmpty() {
            return false;
        }


    }


