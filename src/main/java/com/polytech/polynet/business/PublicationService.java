package com.polytech.polynet.business;


import com.polytech.polynet.objects.Story;

public interface PublicationService {

    void share(Story story1);

    void comment(Comment comment);
}
