package com.polytech.polynet.business;

import com.polytech.polynet.objects.Task;

public interface PublicationService {

    void share(Task task);

    void delete_task(int id);

    void done(int id);

    void modif(int id, String s);
}
