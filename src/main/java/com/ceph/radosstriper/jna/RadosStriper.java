/*
 * RADOS Striper Java - Java bindings for librados
 *
 * Copyright (C) 2013 Wido den Hollander <wido@42on.com>
 *               2016 Arno Broekhof <arnobroekhof@gmail.com>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific
 * language governing permissions and limitations under the License.
 */
package com.ceph.radosstriper.jna;

import com.sun.jna.Callback;
import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.LongByReference;
import com.sun.jna.ptr.PointerByReference;

public interface RadosStriper extends Library {

    RadosStriper INSTANCE = (RadosStriper) Native.loadLibrary("radosstriper", RadosStriper.class);

    int rados_striper_create(Pointer ioctx, Pointer striper);

    void rados_striper_destroy(Pointer striper);

    int rados_striper_set_object_layout_stripe_unit(Pointer striper, int stripe_unit);

    int rados_striper_set_object_layout_stripe_count(Pointer striper, int stripe_count);

    int rados_striper_set_object_layout_object_size(Pointer striper, int object_size);

    int rados_striper_write(Pointer striper, String oid, byte[] buf, int len, long off);

    int rados_striper_write_full(Pointer striper, String oid, byte[] buf, int len);

    int rados_striper_append(Pointer striper, String oid, byte[] buf, int len);

    int rados_striper_read(Pointer striper, String oid, byte[] buf, int len, long off);

    int rados_striper_remove(Pointer striper, String oid);

    int rados_striper_trunc(Pointer striper, String oid, long size);

    int rados_striper_getxattr(Pointer striper, String oid, String xattrName, byte[] buf, long len);

    int rados_striper_setxattr(Pointer striper, String oid, String xattrName, byte[] buf, long len);

    int rados_striper_rmxattr(Pointer striper, String oid, String xattrName);

    int rados_striper_stat(Pointer striper, String oi, LongByReference size, LongByReference mtime);

    // AIO

    int rados_striper_aio_write(Pointer ioctx, String oid, Pointer completion, byte[] buffer, int length, long offset);

    int rados_striper_aio_append(Pointer ioctx, String oid, Pointer completion, byte[] buffer, int length);

    int rados_striper_aio_write_full(Pointer ioctx, String oid, Pointer completion, byte[] buffer, int length);

    int rados_striper_aio_read(Pointer ioctx, String oid, Pointer completion, byte[] buffer, int length, long offset);

    int rados_striper_aio_remove(Pointer ioctx, String oid, Pointer completion);

    void rados_striper_aio_flush(Pointer ioctx);

    int rados_striper_aio_stat(Pointer ioctx, String oid, Pointer completion, LongByReference size, LongByReference mtime);

    // Extended attributes
    /*
    int rados_striper_getxattrs(Pointer ioctx, String oid, Pointer iterator);
    int rados_striper_getxattrs_next(Pointer iterator, PointerByReference attr_name, PointerByReference attr_value, IntByReference len);
    void rados_striper_getxattrs_end(Pointer iterator);
    */
    /*
    int rados_striper_multi_aio_create_completion(void *cb_arg, rados_callback_t cb_complete, rados_callback_t cb_safe, rados_striper_multi_completion_t *pc);
    void rados_striper_multi_aio_wait_for_complete(rados_striper_multi_completion_t c);
    void rados_striper_multi_aio_wait_for_safe(rados_striper_multi_completion_t c);
    int rados_striper_multi_aio_is_complete(rados_striper_multi_completion_t c);
    int rados_striper_multi_aio_is_safe(rados_striper_multi_completion_t c);
    void rados_striper_multi_aio_wait_for_complete_and_cb(rados_striper_multi_completion_t c);
    void rados_striper_multi_aio_wait_for_safe_and_cb(rados_striper_multi_completion_t c);
    int rados_striper_multi_aio_is_complete_and_cb(rados_striper_multi_completion_t c);
    int rados_striper_multi_aio_is_safe_and_cb(rados_striper_multi_completion_t c);
    int rados_striper_multi_aio_get_return_value(rados_striper_multi_completion_t c);
    void rados_striper_multi_aio_release(rados_striper_multi_completion_t c);
    */
}
